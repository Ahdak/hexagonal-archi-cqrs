package net.dammak.businesscase.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetDataQuery {
    private String id ;
}
