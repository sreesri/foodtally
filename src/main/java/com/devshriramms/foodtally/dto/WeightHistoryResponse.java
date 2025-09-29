package com.devshriramms.foodtally.dto;

import com.devshriramms.foodtally.models.WeightEntry;
import java.util.List;

public class WeightHistoryResponse {
    public List<WeightEntry> last7Days;
    public List<WeightEntry> last30Days;
    public List<WeightEntry> last6Months;
    public List<WeightEntry> lastYear;

    public WeightHistoryResponse(List<WeightEntry> last7Days, List<WeightEntry> last30Days,
            List<WeightEntry> last6Months, List<WeightEntry> lastYear) {
        this.last7Days = last7Days;
        this.last30Days = last30Days;
        this.last6Months = last6Months;
        this.lastYear = lastYear;
    }
}
