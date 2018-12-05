/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

/**
 *
 * @author keweiji
 */
public class LeaveRequest {
    private int requestid;
    private static int counts=1;
    private int days;
    private String reason;
    private boolean approved;

    public LeaveRequest(int days, String reason) {
        this.requestid = counts;
        this.days = days;
        this.reason = reason;
        this.approved = false;
        counts++;
    }

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }
    

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(this.getRequestid());
    }
    
}
