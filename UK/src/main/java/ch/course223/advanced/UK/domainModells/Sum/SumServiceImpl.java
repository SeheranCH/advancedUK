package ch.course223.advanced.UK.domainModells.Sum;

import org.springframework.stereotype.Service;

@Service
public class SumServiceImpl implements SumService {

    @Override
    public int getSum(int a, int b) {
        SumFunction sumFunction = (int x, int y) -> x+y;
        return sumFunction.calculateSum(a, b);
    }
}