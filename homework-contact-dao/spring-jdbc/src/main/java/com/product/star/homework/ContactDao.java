package com.product.star.homework;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ContactDao {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public ContactDao(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public List<Contact> getAllContacts() {
        String sql = """
            SELECT ID, NAME, SURNAME, EMAIL, PHONE_NUMBER
            FROM CONTACT
            """;

        return namedJdbcTemplate.query(sql, (rs, rowNum) ->
                new Contact(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PHONE_NUMBER")
                )
        );
    }

    public Contact getContact(long contactId) {
        String sql = """
            SELECT ID, NAME, SURNAME, EMAIL, PHONE_NUMBER
            FROM CONTACT
            WHERE ID = :id
            """;

        return namedJdbcTemplate.queryForObject(
                sql,
                Map.of("id", contactId),
                (rs, rowNum) -> new Contact(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PHONE_NUMBER")
                )
        );
    }

    public long addContact(Contact contact) {
        String sql = """
        INSERT INTO CONTACT (NAME, SURNAME, EMAIL, PHONE_NUMBER)
        VALUES (:name, :surname, :email, :phone)
        RETURNING ID
        """;

        var params = Map.of(
                "name", contact.getName(),
                "surname", contact.getSurname(),
                "email", contact.getEmail(),
                "phone", contact.getPhone()
        );

        return namedJdbcTemplate.queryForObject(
                sql,
                params,
                Long.class
        );
    }

    public void updatePhoneNumber(long contactId, String phoneNumber) {
        String sql = """
            UPDATE CONTACT
            SET PHONE_NUMBER = :phone
            WHERE ID = :id
            """;

        Map<String, Object> params = Map.of(
                "phone", phoneNumber,
                "id", contactId
        );

        namedJdbcTemplate.update(sql, params);
    }

    public void updateEmail(long contactId, String email) {
        String sql = """
            UPDATE CONTACT
            SET EMAIL = :email
            WHERE ID = :id
            """;

        Map<String, Object> params = Map.of(
                "email", email,
                "id", contactId
        );

        namedJdbcTemplate.update(sql, params);
    }

    public void deleteContact(long contactId) {
        String sql = """
            DELETE FROM CONTACT
            WHERE ID = :id
            """;

        Map<String, Object> params = Map.of("id", contactId);

        namedJdbcTemplate.update(sql, params);
    }
}
