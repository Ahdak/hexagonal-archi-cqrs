package net.dammak.businesscase.infrastructure;

import net.dammak.businesscase.application.port.out.LoadDataParam;
import net.dammak.businesscase.application.port.out.LoadDataPort;
import net.dammak.businesscase.domain.Data;

public class DataRepository implements LoadDataPort {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Data loadData(LoadDataParam param) {
        var dataP = jdbcTemplate.getData(param.getId()) ;
        return mapToDomainEntity(dataP);
    }

    private Data mapToDomainEntity(DataPersistence dataP) {
        return Data.builder().id(dataP.getId()).build();
    }
}
