package ch.course223.advanced.UK.domainModells.Sum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sum")
public class SumController {
    @Autowired
    private SumService sumService;
    @GetMapping("{a}/{b}")
    public ResponseEntity<Integer> getSum (@PathVariable int a, @PathVariable int b) {
        return new ResponseEntity<>(sumService.getSum(a, b), HttpStatus.OK);
    }


}
