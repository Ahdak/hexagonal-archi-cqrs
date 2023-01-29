package net.dammak.businesscase.application.service;

import net.dammak.businesscase.application.port.in.GetDataQuery;
import net.dammak.businesscase.application.port.in.GetDataUseCase;
import net.dammak.businesscase.application.port.out.LoadDataParam;
import net.dammak.businesscase.application.port.out.LoadDataPort;
import net.dammak.businesscase.domain.Data;

public class DataService implements GetDataUseCase {

    private final LoadDataPort loadDataPort ;

    public DataService(LoadDataPort loadDataPort) {
        this.loadDataPort = loadDataPort;
    }

    @Override
    public Data getData(GetDataQuery query) {
        return loadDataPort.loadData(LoadDataParam.builder().id(query.getId()).build()) ;
    }
}
