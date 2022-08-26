package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.User;

public interface SuccessService {

    public double calculateTotalSuccess(String username);

    double calculateFloodTestSuccess(String username);

    double calculateFireTestSuccess(String username);

    double calculateEarthquakeTestSuccess(String username);
}
