/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    String nuid;

    public Person(String id) {

        this.id = id;
    }

    public String getPersonId() {
        return id;
    }
    
    public void setPersonId(String id) {
        this.id = id;
    }
    
    public String getNuid() {
    return nuid;
       }
    
    public void setNuid(String nuid) {
    this.nuid = nuid;
    } 

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getPersonId();
    }
}
