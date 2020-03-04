package com.yunionyun.mcp.mcclient.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.LoggerFactory;

public class LoggerUtils {
	private static final String LOG_PATH = "logs/logfile.log";
	private static final String LOG_PATTERN =
			"Yunion Log --> %date %level [%thread] %logger{10} [%file:%line] %msg%n";
	private static final String ROLLING_FILE_MAX_PATTERN = "logs/logfile-%d{yyyy-MM-dd_HH}.log";
	private static final int ROLLING_FILE_MAX_HISTORY = 7;

	public static Logger createLoggerFor(String name) {
		return createLoggerFor(name, LOG_PATH);
	}

	public static Logger createLoggerFor(String name, String file) {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
		encoder.setPattern(LOG_PATTERN);
		encoder.setContext(context);
		encoder.start();

		ConsoleAppender<ILoggingEvent> consoleAppeder = new ConsoleAppender<ILoggingEvent>();
		consoleAppeder.setContext(context);
		consoleAppeder.setName("console");
		consoleAppeder.setEncoder(encoder);
		consoleAppeder.start();

		RollingFileAppender<ILoggingEvent> fileAppender = new RollingFileAppender<ILoggingEvent>();
		fileAppender.setContext(context);
		fileAppender.setName("logFile");
		fileAppender.setEncoder(encoder);
		fileAppender.setAppend(true);
		fileAppender.setFile(file);

		TimeBasedRollingPolicy<ILoggingEvent> logFilePolicy =
				new TimeBasedRollingPolicy<ILoggingEvent>();
		logFilePolicy.setContext(context);
		logFilePolicy.setParent(fileAppender);
		logFilePolicy.setMaxHistory(ROLLING_FILE_MAX_HISTORY);
		logFilePolicy.setFileNamePattern(ROLLING_FILE_MAX_PATTERN);
		logFilePolicy.start();

		fileAppender.setRollingPolicy(logFilePolicy);
		fileAppender.start();

		Logger logger = (Logger) LoggerFactory.getLogger(name);
		logger.addAppender(consoleAppeder);
		logger.addAppender(fileAppender);
		logger.setLevel(Level.INFO);
		logger.setAdditive(false); /* set to true if root should log too */

		return logger;
	}
}
