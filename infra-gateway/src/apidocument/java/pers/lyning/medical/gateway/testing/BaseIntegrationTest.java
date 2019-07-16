package pers.lyning.medical.gateway.testing;

import capital.scalable.restdocs.AutoDocumentation;
import capital.scalable.restdocs.webflux.WebTestClientInitializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.cli.CliDocumentation;
import org.springframework.restdocs.http.HttpDocumentation;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.ExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.function.Consumer;

import static capital.scalable.restdocs.response.ResponseModifyingPreprocessors.limitJsonArrayLength;
import static capital.scalable.restdocs.response.ResponseModifyingPreprocessors.replaceBinaryContent;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;

/**
 * @author lyning
 */
@ActiveProfiles("test")
@ComponentScan(basePackages = {"pers.lyning.medical.gateway"})
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class BaseIntegrationTest {

    protected WebTestClient client;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(final ApplicationContext context,
               final RestDocumentationContextProvider restDocumentation) {

//        this.client = WebTestClient.bindToApplicationContext(context)
//                .configureClient()
//                .filter(documentationConfiguration(restDocumentation).snippets())
//                .build();

        this.client = WebTestClient
                .bindToApplicationContext(context)
                .configureClient()
                .baseUrl("http://localhost:8080/")
                .filter(documentationConfiguration(restDocumentation)
                        .snippets()
                        .withDefaults(WebTestClientInitializer.prepareSnippets(context),
                                CliDocumentation.curlRequest(),
                                HttpDocumentation.httpRequest(),
                                HttpDocumentation.httpResponse(),
                                AutoDocumentation.requestFields(),
                                AutoDocumentation.responseFields(),
                                AutoDocumentation.pathParameters(),
                                AutoDocumentation.requestParameters(),
                                AutoDocumentation.description(),
                                AutoDocumentation.methodAndPath(),
                                AutoDocumentation.section()))
                .build();
    }

    protected <T extends ExchangeResult> Consumer<T> commonDocumentation(final Snippet... snippets) {
        return document("{class-name}/{method-name}", preprocessRequest(),
                this.commonResponsePreprocessor(), snippets);
    }

    protected OperationResponsePreprocessor commonResponsePreprocessor() {
        return preprocessResponse(replaceBinaryContent(),
                limitJsonArrayLength(this.objectMapper), prettyPrint());
    }
}
