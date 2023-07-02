package com.okapi.org;

import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.Command;
import com.okapi.org.validate.impl.CommandExecutor;
import com.okapi.org.validate.impl.FetchCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = CameraBitApplication.class)
public class CameraBitApplicationIntegrationTest {

    @Autowired
    private MatrixService matrixService;

    @MockBean
    private CommandExecutor commandExecutor;

    @Test
    public void testRunCommandFetch() {
        String[] args = {"fetch"};

        CameraBitApplication.main(args);

        Command fetchCommand = new FetchCommand(args, matrixService);
        verify(commandExecutor).executeCommand(fetchCommand);
    }
}
