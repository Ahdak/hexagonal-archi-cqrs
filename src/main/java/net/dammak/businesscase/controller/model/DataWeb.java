package net.dammak.businesscase.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import net.dammak.businesscase.domain.Data;

@Builder
@lombok.Data
@AllArgsConstructor
public class DataWeb {

    private String id ;
    private long duration ;

    public static DataWeb.DataWebBuilder fromDomainEntity(Data data) {
        return DataWeb.builder().id(data.getId()) ;
    }
}
