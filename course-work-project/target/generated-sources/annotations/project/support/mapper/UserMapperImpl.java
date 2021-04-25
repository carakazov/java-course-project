package project.support.mapper;

import javax.annotation.Generated;
import project.dto.IdentityInfoDto;
import project.dto.PersonalInfoDto;
import project.dto.RegistrationDto;
import project.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-25T23:15:37+0300",
    comments = "version: 1.4.0.Beta1, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromRegistrationDto(RegistrationDto source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( sourceIdentityInfoDtoLogin( source ) );
        user.setPassword( sourceIdentityInfoDtoPassword( source ) );
        user.setFirstName( sourcePersonalInfoDtoName( source ) );
        user.setSecondName( sourcePersonalInfoDtoSurname( source ) );
        user.setMiddleName( sourcePersonalInfoDtoMiddleName( source ) );
        user.setEmail( sourcePersonalInfoDtoEmail( source ) );

        return user;
    }

    private String sourceIdentityInfoDtoLogin(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }
        IdentityInfoDto identityInfoDto = registrationDto.getIdentityInfoDto();
        if ( identityInfoDto == null ) {
            return null;
        }
        String login = identityInfoDto.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String sourceIdentityInfoDtoPassword(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }
        IdentityInfoDto identityInfoDto = registrationDto.getIdentityInfoDto();
        if ( identityInfoDto == null ) {
            return null;
        }
        String password = identityInfoDto.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }

    private String sourcePersonalInfoDtoName(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }
        PersonalInfoDto personalInfoDto = registrationDto.getPersonalInfoDto();
        if ( personalInfoDto == null ) {
            return null;
        }
        String name = personalInfoDto.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String sourcePersonalInfoDtoSurname(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }
        PersonalInfoDto personalInfoDto = registrationDto.getPersonalInfoDto();
        if ( personalInfoDto == null ) {
            return null;
        }
        String surname = personalInfoDto.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }

    private String sourcePersonalInfoDtoMiddleName(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }
        PersonalInfoDto personalInfoDto = registrationDto.getPersonalInfoDto();
        if ( personalInfoDto == null ) {
            return null;
        }
        String middleName = personalInfoDto.getMiddleName();
        if ( middleName == null ) {
            return null;
        }
        return middleName;
    }

    private String sourcePersonalInfoDtoEmail(RegistrationDto registrationDto) {
        if ( registrationDto == null ) {
            return null;
        }
        PersonalInfoDto personalInfoDto = registrationDto.getPersonalInfoDto();
        if ( personalInfoDto == null ) {
            return null;
        }
        String email = personalInfoDto.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }
}
