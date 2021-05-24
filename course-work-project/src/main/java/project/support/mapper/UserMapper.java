package project.support.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.RegistrationDto;
import project.dto.UserDto;
import project.model.User;
import project.support.mapper.dto.UserMappingDto;

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

    @Mapping(target = "login", source = "source.user.login")
    @Mapping(target = "personalInfo.name", source = "source.user.firstName")
    @Mapping(target = "personalInfo.surname", source = "source.user.secondName")
    @Mapping(target = "personalInfo.middleName", source = "source.user.middleName")
    @Mapping(target = "personalInfo.email", source = "source.user.email")
    @Mapping(target = "portfolio", source = "source.portfolio.portfolio")
    @Mapping(target = "description", source = "source.user.description")
    UserDto fromUser(UserMappingDto source);

    List<UserDto> fromUser(List<UserMappingDto> source);
}
