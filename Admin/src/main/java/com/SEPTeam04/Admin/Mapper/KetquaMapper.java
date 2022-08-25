package com.SEPTeam04.Admin.Mapper;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import com.SEPTeam04.Admin.Entity.Ketquadoso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface KetquaMapper {
    @Mappings({@Mapping(source = "KetquaMinhNgoc", target = "KetquaDoso")})
    Ketquadoso toMapper(KetquaMinhngoc ketquaMinhngoc);
}
