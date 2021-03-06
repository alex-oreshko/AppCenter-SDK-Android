package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.ingestion.models.one.PartCUtils;

import java.util.Collection;
import java.util.LinkedList;

public class EventLogFactory extends AbstractLogFactory {

    @Override
    public EventLog create() {
        return new EventLog();
    }

    @Override
    public Collection<CommonSchemaLog> toCommonSchemaLogs(Log log) {
        Collection<CommonSchemaLog> commonSchemaLogs = new LinkedList<>();
        for (String transmissionTarget : log.getTransmissionTargetTokens()) {

            /* Part A common fields. */
            CommonSchemaEventLog commonSchemaEventLog = new CommonSchemaEventLog();
            PartAUtils.addPartAFromLog(log, commonSchemaEventLog, transmissionTarget);

            /* Event name goes to Part A too. */
            EventLog eventLog = (EventLog) log;
            commonSchemaEventLog.setName(eventLog.getName());

            /* Properties go to Part C. */
            PartCUtils.addPartCFromLog(eventLog.getProperties(), commonSchemaEventLog);
            commonSchemaLogs.add(commonSchemaEventLog);
        }
        return commonSchemaLogs;
    }
}
