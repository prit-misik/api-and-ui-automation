package models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;


@JsonIncludeProperties(value = {"username","email","password"})
public class UserDataPayload extends UserData{

}
