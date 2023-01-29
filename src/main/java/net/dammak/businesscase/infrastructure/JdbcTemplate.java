package net.dammak.businesscase.infrastructure;

public class JdbcTemplate {

    DataPersistence getData(String id) {
        return DataPersistence.builder().id(id).build();
    }
}
