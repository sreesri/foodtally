package com.devshriramms.foodtally.dto;

public class CalorieStatsResponse {
    public int total7Days;
    public double avg7Days;
    public int total30Days;
    public double avg30Days;
    public int totalMonth;
    public double avgMonth;

    public CalorieStatsResponse(int total7, double avg7, int total30, double avg30, int totalMonth, double avgMonth) {
        this.total7Days = total7;
        this.avg7Days = avg7;
        this.total30Days = total30;
        this.avg30Days = avg30;
        this.totalMonth = totalMonth;
        this.avgMonth = avgMonth;
    }
}
