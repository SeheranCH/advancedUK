package ch.course223.advanced.UK.domainModells.Sum;

import org.springframework.stereotype.Service;

@Service
public interface SumService {
    int getSum (int a, int b);
}
