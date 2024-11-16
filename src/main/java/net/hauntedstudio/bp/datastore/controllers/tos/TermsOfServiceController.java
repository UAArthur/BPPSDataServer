package net.hauntedstudio.bp.datastore.controllers.tos;

import lombok.Getter;
import lombok.Setter;
import net.hauntedstudio.bp.datastore.dto.TermOfUse;
import net.hauntedstudio.bp.datastore.dto.TermsOfServiceResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/apiext/terms_of_use")
public class TermsOfServiceController {


    @PostMapping("get")
    public TermsOfServiceResponse getTermsOfService() {
        TermOfUse term1 = new TermOfUse();
        term1.setId(2);
        term1.setTerm_id(1);
        term1.setType(1);
        term1.setRevision(2);
        term1.setPlatform(1);
        term1.setLang("ja_JP");
        term1.setTitle("『BLUE PROTOCOL』利用規約/チャットサービスに関する注意事項");
        term1.setDesc("BLUE PROTOCOLをプレイするためには、以下の内容に同意していただく必要があります。\n内容をご確認のうえ、チェックをして「同意する」ボタンを押してください。");
        term1.setContent("");
        term1.setSort_id(1);

        TermOfUse term2 = new TermOfUse();
        term2.setId(5);
        term2.setTerm_id(2);
        term2.setType(1);
        term2.setRevision(2);
        term2.setPlatform(1);
        term2.setLang("ja_JP");
        term2.setTitle("『BLUE PROTOCOL』プライバシーポリシー");
        term2.setDesc("BLUE PROTOCOLをプレイするためには、以下の内容に同意していただく必要があります。\n内容をご確認のうえ、チェックをして「同意する」ボタンを押してください。");
        term2.setContent("");
        term2.setSort_id(2);

        TermsOfServiceResponse response = new TermsOfServiceResponse();
        response.setTerms_of_use(Arrays.asList(term1, term2));
        response.setSb_ret_code(0);

        return response;
    }

    @PostMapping("read")
    public TOSReadHC readTermsOfService() {
        TOSReadHC response = new TOSReadHC();
        response.setSb_ret_code(0);
        return response;
    }

    @Getter
    @Setter
    public static class TOSReadHC {
        private List<String> data = new ArrayList<>();
        private int sb_ret_code;
    }
}
