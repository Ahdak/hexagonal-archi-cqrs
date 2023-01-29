package net.dammak.businesscase.controller;

import net.dammak.businesscase.application.port.in.GetDataQuery;
import net.dammak.businesscase.application.port.in.GetDataUseCase;
import net.dammak.businesscase.controller.model.DataWeb;
import net.dammak.businesscase.domain.Data;

import java.time.Duration;
import java.time.LocalDateTime;

public class DataController {

    private final GetDataUseCase getDataUseCase ;

    public DataController(GetDataUseCase getDataUseCase) {
        this.getDataUseCase = getDataUseCase;
    }

    public DataWeb getData(String id) {
        // validate input
        validateInput(id) ;
        var startTime = LocalDateTime.now() ;
        var query = mapInputToUseCaseInput(id) ;
        var data = callTheUseCase(query);
        return mapUseCaseOutputToControllerOutput(startTime, data);
    }

    private DataWeb mapUseCaseOutputToControllerOutput(LocalDateTime startTime, Data data) {
        return DataWeb.fromDomainEntity(data)
                .duration(Duration.between(startTime,LocalDateTime.now()).getSeconds())
                .build();
    }

    private Data callTheUseCase(GetDataQuery query) {
        return getDataUseCase.getData(query);
    }

    private GetDataQuery mapInputToUseCaseInput(String id) {
        return GetDataQuery.builder().id(id).build() ;
    }

    private void validateInput(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Cannot handle null id") ;
        }
    }

}
