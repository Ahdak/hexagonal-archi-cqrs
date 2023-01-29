package net.dammak.businesscase.application.port.out;

import net.dammak.businesscase.domain.Data;

public interface LoadDataPort {

    Data loadData(LoadDataParam param) ;
}
