package project.support.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.RegistrationDto;
import project.dto.UserDto;
import project.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    @Mapping(target = "login", source = "source.identityInfoDto.login")
    @Mapping(target = "password", source = "source.identityInfoDto.password")
    @Mapping(target = "firstName", source = "source.personalInfoDto.name")
    @Mapping(target = "secondName", source = "source.personalInfoDto.surname")
    @Mapping(target = "middleName", source = "source.personalInfoDto.middleName")
    @Mapping(target = "email", source = "source.personalInfoDto.email")
    @Mapping(target = "isLookingForWork", source = "source.lookingForWork")
    @Mapping(target = "roles", ignore = true)
    User fromRegistrationDto(RegistrationDto source);

    @Mapping(target = "personalInfo.name", source = "source.firstName")
    @Mapping(target = "personalInfo.surname", source = "source.secondName")
    @Mapping(target = "personalInfo.middleName", source = "source.middleName")
    @Mapping(target = "personalInfo.email", source = "source.email")
    UserDto fromUser(User source);
}
