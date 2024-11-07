package com.emaple.calenderproject.repository;

import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 현재 일자 메소드
    private Timestamp NowDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date now = new Date();
        String dateString = dateFormat.format(now);
        Timestamp dateParse = Timestamp.valueOf(dateString);

        return dateParse;
    }

    @Override
    public ScheduleResponseDto createSchedule(Schedule schedule) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.withTableName("schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("name", schedule.getName());
        parameters.put("password", schedule.getPassword());
        parameters.put("title", schedule.getTitle());
        parameters.put("contents", schedule.getContents());
        parameters.put("createDate", NowDate());
        parameters.put("modifiedDate", NowDate());

        Number id = insert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(id.longValue(), schedule.getName(), schedule.getTitle(), schedule.getContents(), schedule.getCreateDate(), schedule.getModifiedDate());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules(String sortSchedule) {
        if (Objects.equals(sortSchedule, "modified_date")) {
            return jdbcTemplate.query("select * from schedule order by modified_date desc", scheduleRowMapper());
        } else if (Objects.equals(sortSchedule, "name")) {
            return jdbcTemplate.query("select * from schedule order by name desc", scheduleRowMapper());
        } else if (Objects.equals(sortSchedule, "modified_date&name") || Objects.equals(sortSchedule, "name&modified_date")) {
            return jdbcTemplate.query("select * from schedule order by name, modified_date desc", scheduleRowMapper());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No schedule found");

        }
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        List<ScheduleResponseDto> result =
                jdbcTemplate.query("select * from schedule where id=?", scheduleRowMapper(), id);
        return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found"));
    }

    @Override
    public void updateSchedule(Long id, String name, String title, String contents, String modifiedDate, String password) {
        List<Schedule> result =
                jdbcTemplate.query("select * from schedule where id=?", scheduleRowMapperV2(), id);

        if (password != null && Objects.equals(password, result.get(0).getPassword())) {

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("name", (name == null || name.isEmpty()) ? result.get(0).getName() : name);
            parameters.put("title", (title == null || title.isEmpty()) ? result.get(0).getTitle() : title);
            parameters.put("contents", (contents == null || contents.isEmpty()) ? result.get(0).getContents() : contents);


            jdbcTemplate.update("update schedule set modified_date=?, name=?, title=?, contents=? where id=?", NowDate(), name, title, contents, id);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "wrong password");
        }
    }

    @Override
    public void deleteSchedule(Long id, String password) {
        List<Schedule> result =
                jdbcTemplate.query("select * from schedule where id=?", scheduleRowMapperV2(), id);

        String currentPassword = result.get(0).getPassword();

        if (Objects.equals(currentPassword, password)) {
            jdbcTemplate.update("delete from schedule where id=?", id);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Schedule not found");
        }
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("create_date"),
                        rs.getString("modified_date")
                );
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapperV2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getString("password")
                );
            }
        };
    }
}
