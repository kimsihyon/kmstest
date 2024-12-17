package kmstest.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import kmstest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/riders")
@Transactional
public class RiderController {

    @Autowired
    RiderRepository riderRepository;

    @RequestMapping(
        value = "/riders/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider accept(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptCommand acceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/accept  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.accept(acceptCommand);

        riderRepository.save(rider);
        return rider;
    }

    @RequestMapping(
        value = "/riders/{id}/dellverystrat",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider dellveryStrat(
        @PathVariable(value = "id") Long id,
        @RequestBody DellveryStratCommand dellveryStratCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/dellveryStrat  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.dellveryStrat(dellveryStratCommand);

        riderRepository.save(rider);
        return rider;
    }

    @RequestMapping(
        value = "/riders/{id}/dellverycomplete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider dellverycomplete(
        @PathVariable(value = "id") Long id,
        @RequestBody DellverycompleteCommand dellverycompleteCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/dellverycomplete  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.dellverycomplete(dellverycompleteCommand);

        riderRepository.save(rider);
        return rider;
    }
}
//>>> Clean Arch / Inbound Adaptor
