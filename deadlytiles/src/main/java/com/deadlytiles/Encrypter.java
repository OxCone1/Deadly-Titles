package com.deadlytiles;
import org.jasypt.util.text.AES256TextEncryptor;

public class Encrypter {
    public String EncryptGameID(String password) {   
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword("518c7f42a4f209bddde3b18aa0a53001");
        String myEncryptedPassword = aesEncryptor.encrypt(password);
        return myEncryptedPassword;     
    }
    
    public String DecryptGameID(String passwordFromConfigFile) {           
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword("518c7f42a4f209bddde3b18aa0a53001");
        String decryptedPassword = aesEncryptor.decrypt(passwordFromConfigFile);
        return decryptedPassword;   
    }
}


//Project by Vadims "OxCone" Lapins