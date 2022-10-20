package io.hcxprotocol.helper;

import io.hcxprotocol.utils.JSONUtils;
import io.hcxprotocol.utils.Operations;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateHelperTest {

    protected Map<String,Object> getRequestBody() {
        return Collections.singletonMap("payload","eyJlbmMiOiJBMjU2R0NNIiwKImFsZyI6IlJTQS1PQUVQIiwKIngtaGN4LXNlbmRlcl9jb2RlIjoiMS0zYTNiZDY4YS04NDhhLTRkNTItOWVjMi0wN2E5MmQ3NjVmYjQiLAoieC1oY3gtcmVjaXBpZW50X2NvZGUiOiIxLWNlMjNjY2RjLWU2NDUtNGUzNS05N2I4LTBiZDhmZWY0M2VjZCIsCiJ4LWhjeC1hcGlfY2FsbF9pZCI6IjI2YjEwNjBjLTFlODMtNDYwMC05NjEyLWVhMzFlMGNhNTA5MyIsCiJ4LWhjeC1jb3JyZWxhdGlvbl9pZCI6IjVlOTM0ZjkwLTExMWQtNGYwYi1iMDE2LWMyMmQ4MjA2NzRlMSIsCiJ4LWhjeC10aW1lc3RhbXAiOiIyMDIxLTEwLTI3VDIwOjM1OjUyLjYzNiswNTMwIiwKIngtaGN4LXN0YXR1cyI6InJlcXVlc3QucXVldWVkIiwKIngtaGN4LXdvcmtmbG93X2lkIjoiMjZiMTA2MGMtMWU4My00NjAwLTk2MTItZWEzMWUwY2E1MDk0IiwKIngtaGN4LWRlYnVnX2ZsYWciOiJJbmZvIiwKIngtaGN4LWRlYnVnX2RldGFpbHMiOnsiY29kZSI6IkVSUl9JTlZBTElEX0VOQ1JZUFRJT04iLCJtZXNzYWdlIjoiUmVjaXBpZW50IEludmFsaWQgRW5jcnlwdGlvbiIsInRyYWNlIjoiIn0KfQ==.6KB707dM9YTIgHtLvtgWQ8mKwboJW3of9locizkDTHzBC2IlrT1oOQ.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY.Mz-VPPyU4RlcuYv1IwIvzw");
    }

    protected Map<String,Object> getOnRequestBody(){
        return Collections.singletonMap("payload","eyJlbmMiOiJBMjU2R0NNIiwKImFsZyI6IlJTQS1PQUVQIiwKIngtaGN4LXNlbmRlcl9jb2RlIjoiMS0zYTNiZDY4YS04NDhhLTRkNTItOWVjMi0wN2E5MmQ3NjVmYjQiLAoieC1oY3gtcmVjaXBpZW50X2NvZGUiOiIxLWNlMjNjY2RjLWU2NDUtNGUzNS05N2I4LTBiZDhmZWY0M2VjZCIsCiJ4LWhjeC1hcGlfY2FsbF9pZCI6IjI2YjEwNjBjLTFlODMtNDYwMC05NjEyLWVhMzFlMGNhNTA5MyIsCiJ4LWhjeC1jb3JyZWxhdGlvbl9pZCI6IjVlOTM0ZjkwLTExMWQtNGYwYi1iMDE2LWMyMmQ4MjA2NzRlMSIsCiJ4LWhjeC10aW1lc3RhbXAiOiIyMDIxLTEwLTI3VDIwOjM1OjUyLjYzNiswNTMwIiwKIngtaGN4LXN0YXR1cyI6InJlc3BvbnNlLnBhcnRpYWwiLAoieC1oY3gtd29ya2Zsb3dfaWQiOiIyNmIxMDYwYy0xZTgzLTQ2MDAtOTYxMi1lYTMxZTBjYTUwOTQiLAoieC1oY3gtZGVidWdfZmxhZyI6IkluZm8iLAoieC1oY3gtZGVidWdfZGV0YWlscyI6eyJjb2RlIjoiRVJSX0lOVkFMSURfRU5DUllQVElPTiIsIm1lc3NhZ2UiOiJSZWNpcGllbnQgSW52YWxpZCBFbmNyeXB0aW9uIiwidHJhY2UiOiIifQp9.6KB707dM9YTIgHtLvtgWQ8mKwboJW3of9locizkDTHzBC2IlrT1oOQ.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY.Mz-VPPyU4RlcuYv1IwIvzw");
    }

    @Test
    void testActionJWEPayloadSuccess() throws Exception {
        boolean isValid = ValidateHelper.getInstance().validateRequest(JSONUtils.serialize(getRequestBody()), Operations.COVERAGE_ELIGIBILITY_CHECK,new HashMap<>());
        assertEquals(true, isValid);
    }
    @Test
    void testOnActionJWEPayloadSuccess() throws Exception {
        boolean isValid = ValidateHelper.getInstance().validateRequest(JSONUtils.serialize(getOnRequestBody()), Operations.COVERAGE_ELIGIBILITY_ON_CHECK,new HashMap<>());
        assertEquals(true, isValid);
    }
    @Test
    void testActionJWEPayloadSuccessFail() {
        boolean isValid = ValidateHelper.getInstance().validateRequest(null,Operations.COVERAGE_ELIGIBILITY_CHECK,new HashMap<>());
        assertEquals(false, isValid);
    }
    @Test
    void testOnActionJWEPayloadSuccessFail() {
        boolean isValid = ValidateHelper.getInstance().validateRequest(null,Operations.COVERAGE_ELIGIBILITY_CHECK,new HashMap<>());
        assertEquals(false, isValid);
    }
    @Test
    void testOnActionJWEPayloadFail() {
        String payload = "{\n" +
               "    \"x-hcx-recipient_code\": \"1-3a3bd68a-848a-4d52-9ec2-07a92d765fb4\",\n" +
               "    \"x-hcx-timestamp\": \"2021-10-27T20:35:52.636+0530\",\n" +
               "    \"x-hcx-sender_code\": \"1-2ff1f493-c4d4-4fc7-8d41-aaabb997af23\",\n" +
               "    \"x-hcx-correlation_id\": \"5e934f90-111d-4f0b-b016-c22d820674e1\",\n" +
               "    \"x-hcx-api_call_id\": \"26b1060c-1e83-4600-9612-ea31e0ca5194\",\n" +
               "    \"x-hcx-status\": \"response.redirect\",\n" +
               "    \"x-hcx-redirect_to\": \"1-74f6cb29-4116-42d0-9fbb-adb65e6a64ac\"\n" +
               "}";
        boolean isValid = ValidateHelper.getInstance().validateRequest(payload, Operations.COVERAGE_ELIGIBILITY_CHECK, new HashMap<>());
        assertEquals(false, isValid);
    }

    @Test
    void testActionJWEPayloadFail() {
        String payload = "{\n" +
                "    \"x-hcx-recipient_code\": \"1-3a3bd68a-848a-4d52-9ec2-07a92d765fb4\",\n" +
                "    \"x-hcx-timestamp\": \"2021-10-27T20:35:52.636+0530\",\n" +
                "    \"x-hcx-sender_code\": \"1-2ff1f493-c4d4-4fc7-8d41-aaabb997af23\",\n" +
                "    \"x-hcx-correlation_id\": \"5e934f90-111d-4f0b-b016-c22d820674e1\",\n" +
                "    \"x-hcx-api_call_id\": \"26b1060c-1e83-4600-9612-ea31e0ca5194\",\n" +
                "    \"x-hcx-status\": \"response.redirect\",\n" +
                "    \"x-hcx-redirect_to\": \"1-74f6cb29-4116-42d0-9fbb-adb65e6a64ac\"\n" +
                "}";
        boolean isValid = ValidateHelper.getInstance().validateRequest(payload, Operations.COVERAGE_ELIGIBILITY_ON_CHECK, new HashMap<>());
        assertEquals(false, isValid);
    }



}
