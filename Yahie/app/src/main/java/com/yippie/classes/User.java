package com.yippie.classes;

/**
 * User class
 */

public class User
{
    private Integer uid;
    private String name;
    private String email;
    private String passwordEncoded;

    // Constructor
    public User()
    {
        uid = 0;
        name = "";
        email = "";
        passwordEncoded = "";
    }

    // Getter
    public Integer getUid() {
        return uid;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPasswordEncoded(){
        return passwordEncoded;
    }

    // Setter
    public void setUid(Integer id){
        uid = id;
    }

    public void setName(String N){
        name = N;
    }

    public void setEmail(String E){
        email = E;
    }

    public void setPasswordEncoded(String PE){
        passwordEncoded = PE;
    }

}
