package com.reshika.esoftwarica.ui;

import java.io.Serializable;

public class Contacts  {
    private String name;
    private String age;
    private String address;
    private String gender;
    private int imageId;


    public Contacts(String name,String age, String address,String gender,int imageId)
    {
        this.name=name;
        this.age=age;
        this.address=address;
        this.gender=gender;
        this.imageId=imageId;

    }

    //Getter Setter
    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name= name;
    }

    public String getAge()
    {
        return age;
    }
    public void setAge()
    {
        this.age= age;
    }

    public String getAddress()
    {
        return address;
    }
    public void setAddress()
    {
        this.address= address;
    }

    public String getGender()
    {
        return gender;
    }
    public void setGender()
    {
        this.gender= gender;
    }

    public int getImageId()
    {
        return imageId;
    }
    public void setImageId()
    {
        this.imageId= imageId;
    }


}
