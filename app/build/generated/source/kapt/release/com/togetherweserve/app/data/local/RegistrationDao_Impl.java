package com.togetherweserve.app.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
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
public final class RegistrationDao_Impl implements RegistrationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RegistrationEntity> __insertionAdapterOfRegistrationEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public RegistrationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRegistrationEntity = new EntityInsertionAdapter<RegistrationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `registrations` (`registrationId`,`eventId`,`eventTitle`,`eventDateTime`,`groupId`,`status`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RegistrationEntity entity) {
        if (entity.getRegistrationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getRegistrationId());
        }
        if (entity.getEventId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEventId());
        }
        if (entity.getEventTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEventTitle());
        }
        statement.bindLong(4, entity.getEventDateTime());
        if (entity.getGroupId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getGroupId());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
      }
    };
    this.__preparedStmtOfUpdateStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE registrations SET status = ? WHERE registrationId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM registrations";
        return _query;
      }
    };
  }

  @Override
  public Object upsertAll(final List<RegistrationEntity> registrations,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRegistrationEntity.insert(registrations);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsert(final RegistrationEntity registration,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRegistrationEntity.insert(registration);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStatus(final String id, final String status,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatus.acquire();
        int _argIndex = 1;
        if (status == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, status);
        }
        _argIndex = 2;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
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
          __preparedStmtOfUpdateStatus.release(_stmt);
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
  public Flow<List<RegistrationEntity>> observeAll() {
    final String _sql = "SELECT * FROM registrations ORDER BY eventDateTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"registrations"}, new Callable<List<RegistrationEntity>>() {
      @Override
      @NonNull
      public List<RegistrationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRegistrationId = CursorUtil.getColumnIndexOrThrow(_cursor, "registrationId");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "eventId");
          final int _cursorIndexOfEventTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "eventTitle");
          final int _cursorIndexOfEventDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "eventDateTime");
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "groupId");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<RegistrationEntity> _result = new ArrayList<RegistrationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RegistrationEntity _item;
            final String _tmpRegistrationId;
            if (_cursor.isNull(_cursorIndexOfRegistrationId)) {
              _tmpRegistrationId = null;
            } else {
              _tmpRegistrationId = _cursor.getString(_cursorIndexOfRegistrationId);
            }
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            final String _tmpEventTitle;
            if (_cursor.isNull(_cursorIndexOfEventTitle)) {
              _tmpEventTitle = null;
            } else {
              _tmpEventTitle = _cursor.getString(_cursorIndexOfEventTitle);
            }
            final long _tmpEventDateTime;
            _tmpEventDateTime = _cursor.getLong(_cursorIndexOfEventDateTime);
            final String _tmpGroupId;
            if (_cursor.isNull(_cursorIndexOfGroupId)) {
              _tmpGroupId = null;
            } else {
              _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new RegistrationEntity(_tmpRegistrationId,_tmpEventId,_tmpEventTitle,_tmpEventDateTime,_tmpGroupId,_tmpStatus);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
