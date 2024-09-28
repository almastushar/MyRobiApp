# Use an official Maven image to install Java and Maven
FROM maven:3.8.5-openjdk-11-slim

# Set environment variables for Android SDK
ENV ANDROID_SDK_ROOT=/opt/android-sdk
ENV PATH="$PATH:$ANDROID_SDK_ROOT/cmdline-tools:$ANDROID_SDK_ROOT/platform-tools"

# Install Node.js (required for Appium)
RUN apt-get update && apt-get install -y curl && \
    curl -sL https://deb.nodesource.com/setup_14.x | bash - && \
    apt-get install -y nodejs && \
	apt-get install -y unzip && \
    npm install -g appium && \
	appium driver install uiautomator2 && \
	appium driver install xcuitest

# Install Android SDK
RUN mkdir -p ${ANDROID_SDK_ROOT} && \
	cd ${ANDROID_SDK_ROOT} && \
    curl -L -o cmdline-tools.zip https://dl.google.com/android/repository/commandlinetools-linux-7302050_latest.zip && \
	unzip cmdline-tools.zip && \
    rm cmdline-tools.zip

# Install the system images after the emulator for M2
#RUN yes | ${ANDROID_SDK_ROOT}/cmdline-tools/bin/sdkmanager --sdk_root=${ANDROID_SDK_ROOT} --install "system-images;android-34;google_apis_playstore;arm64-v8a"

# Install the system images after the emulator for windows
RUN yes | ${ANDROID_SDK_ROOT}/cmdline-tools/bin/sdkmanager --sdk_root=${ANDROID_SDK_ROOT} --install "system-images;android-34;google_apis_playstore;x86_64"

# Install other required components
RUN yes | ${ANDROID_SDK_ROOT}/cmdline-tools/bin/sdkmanager --sdk_root=${ANDROID_SDK_ROOT} --licenses

# Install other required components
RUN yes | ${ANDROID_SDK_ROOT}/cmdline-tools/bin/sdkmanager --sdk_root=${ANDROID_SDK_ROOT} --install "platform-tools" "platforms;android-34" "build-tools;34.0.0"

# Create the AVD configuration
RUN mkdir -p ~/.android/avd && \
    echo "avd.ini.encoding=UTF-8" > ~/.android/avd/test_avd.ini && \
    echo "hw.gpu.enabled=yes" >> ~/.android/avd/test_avd.ini && \
    echo "hw.gpu.mode=auto" >> ~/.android/avd/test_avd.ini && \
    echo "image.sysdir.1=system-images/android-34/default/x86_64/" >> ~/.android/avd/test_avd.ini && \
    echo "avdId=test_avd" >> ~/.android/avd/test_avd.ini	
	
# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the pom.xml file first to download dependencies
COPY pom.xml ./

# Download dependencies for offline use
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY . .

RUN ${ANDROID_SDK_ROOT}/platform-tools/adb kill-server
	${ANDROID_SDK_ROOT}/platform-tools/adb start-server

# Build the Maven project
RUN mvn clean test -DsuiteXmlFile=testNGSuites/testng.xml

# Expose the Appium server port
EXPOSE 4723

# Run Appium and execute the tests
CMD appium & mvn test