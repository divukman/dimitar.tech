package tech.dimitar.spring.properties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DummyBean {
    private String text;
}
