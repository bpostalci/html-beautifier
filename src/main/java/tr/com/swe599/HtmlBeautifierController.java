package tr.com.swe599;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "html-operations")
@RestController
public class HtmlBeautifierController {

    private final HtmlBeautifierService htmlBeautifierService;

    HtmlBeautifierController(HtmlBeautifierService htmlBeautifierService) {
        this.htmlBeautifierService = htmlBeautifierService;
    }

    @RequestMapping(value = "/beautify", method = RequestMethod.POST)
    public String beautify(@RequestBody String htmlPayload) {

        log.info("/beautify received payload: " + htmlPayload);

        // TODO:
        BeautifyDto dto = htmlBeautifierService.beautify(htmlPayload);
        String responseJson = JsonHelper.toJsonString(dto);

        log.info("/beautify response: " + responseJson);

        return responseJson;
    }
}
