//new vbe.Builder(branch: '7.4.x', javaHome: "/opt/oracle/openjdk-11.0.14.1_1").buildAndTest(this)
new vbe.Builder(jobName: "vbe-eap-tmp-8.0.0.dev", branch: '8.0.0.dev', javaHome: "/opt/oracle/openjdk-11.0.14.1_1", gitRepositoryUrl: 'git@github.com:jbossas/jboss-eap8.git',vbeRepositoryNames: 'jboss-eap-8.0-product-repository', vbeChannels: "${VPE_EAP_8_CHANNEL}").buildAndTest(this)
//WFCORE for eap8... needs hacks...
new eap7.Builder(branch:'18.0.x',
                 jobName: 'vbe-wildfly-core-eap',
                 gitRepositoryUrl: "git@github.com:jbossas/wildfly-core-eap.git",
                 javaHome: "/opt/oracle/openjdk-11.0.14.1_1",
                  customParams: {
                    stringParam {
                        name("TEST_OPTS")
                        defaultValue("-DskipTests -Dversion.org.wildfly.openssl.natives=2.2.0.Final-redhat-00002")
                    }
                    stringParam {
                        name("BUILD_OPTS")
                        defaultValue("-DskipTests -Dversion.org.wildfly.openssl.natives=2.2.0.Final-redhat-00002")
                    }
                    stringParam {
                        name("MAVEN_OPTS")
                        defaultValue("-Dmaven.wagon.http.ssl.insecure=true -Dhttps.protocols=TLSv1.2 -DskipTests -Dversion.org.wildfly.openssl.natives=2.2.0.Final-redhat-00002")
                    }
                  }
                ).buildAndTest(this)
EapView.jobList(this, 'vbe-wildfly', 'vbe-wildfly-core.*')
EapView.jobList(this, 'vbe', 'vbe-eap.*')
