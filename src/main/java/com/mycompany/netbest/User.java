package com.mycompany.netbest;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author domin
 */
public class User {
    private StringProperty userLogin;
    private StringProperty userPassword; 
    private IntegerProperty userPermissions;
    private StringProperty userFirstName;
    private StringProperty userLastName;
    
    /**
     * Constructor
     */
    public User(){
        this.userLogin =  new SimpleStringProperty(); 
        this.userPassword =  new SimpleStringProperty();  
        this.userPermissions = new SimpleIntegerProperty();
        this.userFirstName = new SimpleStringProperty();
        this.userLastName =  new SimpleStringProperty();
          
    }

        /**
         * 
         * @return User first name
         */
        public String getUserFirstName(){
            return userFirstName.get();
        }
        
        /**
         * Set user first name
         * @param UserFirstName 
         */
        public void setUserFirstName(String UserFirstName){
            this.userFirstName.set(UserFirstName);            
        }
        
        /**
         * 
         * @return User first name for table
         */
        public StringProperty UserFirstNameProperty(){
            return userFirstName;
        } 
        
        /**
         * 
         * @return User last name
         */
        public String getUserLastName(){
            return userLastName.get();
        }
        
        /**
         * Set user last name
         * @param UserLastName 
         */
        public void setUserLastName(String UserLastName){
            this.userLastName.set(UserLastName);            
        }
        
        /**
         * 
         * @return jser last name for table
         */
        public StringProperty UserLastNameProperty(){
            return userLastName;
        }
        
        /**
         * 
         * @return User permission
         */
        public int getUserPermissions(){
            return userPermissions.get();
        }
        
        /**
         * Set user permission
         * @param UserPermissions 
         */
        public void setUserPermissions(int UserPermissions){
            this.userPermissions.set(UserPermissions);            
        }
        
        /**
         * 
         * @return User permission for table
         */
        public IntegerProperty UserPermissionsProperty(){
            return userPermissions;
        }
        
        /**
         * 
         * @return User login
         */
        public String getUserLogin(){
            return userLogin.get();
        }
        
        /**
         * Set user login
         * @param UserLogin 
         */
        public void setUserLogin(String UserLogin){
            this.userLogin.set(UserLogin);            
        }
        
        /**
         * 
         * @return user login for table
         */
        public StringProperty UserLoginProperty(){
            return userLogin;
        } 
        
        /**
         * 
         * @return User password
         */
        public String getUserPassword(){
            return userPassword.get();
        }
        
        /**
         * Set user password
         * @param UserPassword 
         */
        public void setUserPassword(String UserPassword){
            this.userPassword.set(UserPassword);            
        }
        
        /**
         * 
         * @return User password for table
         */
        public StringProperty UserPasswordProperty(){
            return userPassword;
        }
}
