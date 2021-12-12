package controller;

import lombok.Builder;
import model.PackageHistory;

import java.time.LocalDateTime;

@Builder
public class Comparator implements java.util.Comparator<PackageHistory> {
    @Override
    public int compare(PackageHistory p1, PackageHistory p2) {
        LocalDateTime p1d = LocalDateTime.parse(p1.getCreatedAt());
        LocalDateTime p2d = LocalDateTime.parse(p2.getCreatedAt());
        if (p1d.isAfter(p2d)) {
            return 1;
        }
        return 0;
    }
}
