package net.dammak.businesscase.application.port.in;

import net.dammak.businesscase.domain.Data;

public interface GetDataUseCase {

    Data getData(GetDataQuery query) ;
}
