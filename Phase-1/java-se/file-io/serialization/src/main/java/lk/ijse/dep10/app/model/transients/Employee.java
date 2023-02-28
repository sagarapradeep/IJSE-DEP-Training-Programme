package lk.ijse.dep10.app.model.transients;

import java.io.Serializable;

public class Employee implements Serializable {
    private String id;
    private transient PersonalInfo employeeInfo;
    private transient  PersonalInfo spouseInfo;
    private Status status;

    public Employee(String id, PersonalInfo employeeInfo, PersonalInfo spouseInfo, Status status) {
        this.id = id;
        this.employeeInfo = employeeInfo;
        this.spouseInfo = spouseInfo;
        this.status = status;
    }

    public Employee() {
    }

    public String getEmployeeName() {
        return employeeInfo.getName();
    }

    public String getSpouseName() {
        return this.status == Status.MARRIED ? spouseInfo.getName() : "-";
    }



    /*Getter*/
    public String getId() {
        return id;
    }

    public PersonalInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public PersonalInfo getSpouseInfo() {
        return spouseInfo;
    }

    public Status getStatus() {
        return status;
    }


    /*Setter*/
    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeInfo(PersonalInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public void setSpouseInfo(PersonalInfo spouseInfo) {
        this.spouseInfo = spouseInfo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
