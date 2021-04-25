package project.support.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.RegistrationDto;
import project.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    @Mapping(target = "login", source = "source.identityInfoDto.login")
    @Mapping(target = "password", source = "source.identityInfoDto.password")
    @Mapping(target = "firstName", source = "source.personalInfoDto.name")
    @Mapping(target = "secondName", source = "source.personalInfoDto.surname")
    @Mapping(target = "middleName", source = "source.personalInfoDto.middleName")
    @Mapping(target = "email", source = "source.personalInfoDto.email")
    User fromRegistrationDto(RegistrationDto source);
}
