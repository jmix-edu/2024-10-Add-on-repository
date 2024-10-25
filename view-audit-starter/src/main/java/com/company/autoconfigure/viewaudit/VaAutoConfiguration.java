package com.company.autoconfigure.viewaudit;

import com.company.viewaudit.VaConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({VaConfiguration.class})
public class VaAutoConfiguration {
}

