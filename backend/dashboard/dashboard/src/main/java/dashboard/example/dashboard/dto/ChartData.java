package dashboard.example.dashboard.dto;

import java.util.List;

public class ChartData {
    public List<String> labels;
    public List<Integer> data;

    public ChartData(List<String> labels, List<Integer> data) {
        this.labels = labels;
        this.data = data;
    }
}