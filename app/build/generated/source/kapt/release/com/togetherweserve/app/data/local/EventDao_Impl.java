package com.togetherweserve.app.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EventDao_Impl implements EventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EventEntity> __insertionAdapterOfEventEntity;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public EventDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEventEntity = new EntityInsertionAdapter<EventEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `events` (`eventId`,`title`,`cause`,`description`,`dateTime`,`location`,`slotsAvailable`,`volunteersGoing`,`organiserId`,`organiserName`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final EventEntity entity) {
        if (entity.getEventId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getEventId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getCause() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCause());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        statement.bindLong(5, entity.getDateTime());
        if (entity.getLocation() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLocation());
        }
        statement.bindLong(7, entity.getSlotsAvailable());
        statement.bindLong(8, entity.getVolunteersGoing());
        if (entity.getOrganiserId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOrganiserId());
        }
        if (entity.getOrganiserName() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getOrganiserName());
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM events";
        return _query;
      }
    };
  }

  @Override
  public Object upsertAll(final List<EventEntity> events,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEventEntity.insert(events);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsert(final EventEntity event, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEventEntity.insert(event);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clear(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClear.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<EventEntity>> observeAll() {
    final String _sql = "SELECT * FROM events ORDER BY dateTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"events"}, new Callable<List<EventEntity>>() {
      @Override
      @NonNull
      public List<EventEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "eventId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCause = CursorUtil.getColumnIndexOrThrow(_cursor, "cause");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfSlotsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "slotsAvailable");
          final int _cursorIndexOfVolunteersGoing = CursorUtil.getColumnIndexOrThrow(_cursor, "volunteersGoing");
          final int _cursorIndexOfOrganiserId = CursorUtil.getColumnIndexOrThrow(_cursor, "organiserId");
          final int _cursorIndexOfOrganiserName = CursorUtil.getColumnIndexOrThrow(_cursor, "organiserName");
          final List<EventEntity> _result = new ArrayList<EventEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final EventEntity _item;
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCause;
            if (_cursor.isNull(_cursorIndexOfCause)) {
              _tmpCause = null;
            } else {
              _tmpCause = _cursor.getString(_cursorIndexOfCause);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateTime;
            _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final int _tmpSlotsAvailable;
            _tmpSlotsAvailable = _cursor.getInt(_cursorIndexOfSlotsAvailable);
            final int _tmpVolunteersGoing;
            _tmpVolunteersGoing = _cursor.getInt(_cursorIndexOfVolunteersGoing);
            final String _tmpOrganiserId;
            if (_cursor.isNull(_cursorIndexOfOrganiserId)) {
              _tmpOrganiserId = null;
            } else {
              _tmpOrganiserId = _cursor.getString(_cursorIndexOfOrganiserId);
            }
            final String _tmpOrganiserName;
            if (_cursor.isNull(_cursorIndexOfOrganiserName)) {
              _tmpOrganiserName = null;
            } else {
              _tmpOrganiserName = _cursor.getString(_cursorIndexOfOrganiserName);
            }
            _item = new EventEntity(_tmpEventId,_tmpTitle,_tmpCause,_tmpDescription,_tmpDateTime,_tmpLocation,_tmpSlotsAvailable,_tmpVolunteersGoing,_tmpOrganiserId,_tmpOrganiserName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getById(final String id, final Continuation<? super EventEntity> $completion) {
    final String _sql = "SELECT * FROM events WHERE eventId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<EventEntity>() {
      @Override
      @Nullable
      public EventEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "eventId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCause = CursorUtil.getColumnIndexOrThrow(_cursor, "cause");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfSlotsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "slotsAvailable");
          final int _cursorIndexOfVolunteersGoing = CursorUtil.getColumnIndexOrThrow(_cursor, "volunteersGoing");
          final int _cursorIndexOfOrganiserId = CursorUtil.getColumnIndexOrThrow(_cursor, "organiserId");
          final int _cursorIndexOfOrganiserName = CursorUtil.getColumnIndexOrThrow(_cursor, "organiserName");
          final EventEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCause;
            if (_cursor.isNull(_cursorIndexOfCause)) {
              _tmpCause = null;
            } else {
              _tmpCause = _cursor.getString(_cursorIndexOfCause);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpDateTime;
            _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final int _tmpSlotsAvailable;
            _tmpSlotsAvailable = _cursor.getInt(_cursorIndexOfSlotsAvailable);
            final int _tmpVolunteersGoing;
            _tmpVolunteersGoing = _cursor.getInt(_cursorIndexOfVolunteersGoing);
            final String _tmpOrganiserId;
            if (_cursor.isNull(_cursorIndexOfOrganiserId)) {
              _tmpOrganiserId = null;
            } else {
              _tmpOrganiserId = _cursor.getString(_cursorIndexOfOrganiserId);
            }
            final String _tmpOrganiserName;
            if (_cursor.isNull(_cursorIndexOfOrganiserName)) {
              _tmpOrganiserName = null;
            } else {
              _tmpOrganiserName = _cursor.getString(_cursorIndexOfOrganiserName);
            }
            _result = new EventEntity(_tmpEventId,_tmpTitle,_tmpCause,_tmpDescription,_tmpDateTime,_tmpLocation,_tmpSlotsAvailable,_tmpVolunteersGoing,_tmpOrganiserId,_tmpOrganiserName);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
