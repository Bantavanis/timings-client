package com.kevingann.beans.cicd.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Include {

    @JsonProperty("useragent_family")
    private String userAgentFamily;

    @JsonProperty("os_family")
    private String osFamily;

    @JsonProperty("env_tester")
    private String environmentTester;

    public String getUserAgentFamily() {
        return userAgentFamily;
    }

    public void setUserAgentFamily(String userAgentFamily) {
        this.userAgentFamily = userAgentFamily;
    }

    public String getOsFamily() {
        return osFamily;
    }

    public void setOsFamily(String osFamily) {
        this.osFamily = osFamily;
    }

    public String getEnvironmentTester() {
        return environmentTester;
    }

    public void setEnvironmentTester(String environmentTester) {
        this.environmentTester = environmentTester;
    }

    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE).toString();
    }
}