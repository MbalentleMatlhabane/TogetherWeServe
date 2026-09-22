package com.togetherweserve.app.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PendingActionDao_Impl implements PendingActionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PendingActionEntity> __insertionAdapterOfPendingActionEntity;

  private final EntityDeletionOrUpdateAdapter<PendingActionEntity> __deletionAdapterOfPendingActionEntity;

  public PendingActionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPendingActionEntity = new EntityInsertionAdapter<PendingActionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `pending_actions` (`id`,`eventId`,`actionType`,`groupCode`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PendingActionEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getEventId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEventId());
        }
        if (entity.getActionType() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getActionType());
        }
        if (entity.getGroupCode() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getGroupCode());
        }
        statement.bindLong(5, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfPendingActionEntity = new EntityDeletionOrUpdateAdapter<PendingActionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pending_actions` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PendingActionEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final PendingActionEntity action,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPendingActionEntity.insertAndReturnId(action);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final PendingActionEntity action,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPendingActionEntity.handle(action);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<PendingActionEntity>> $completion) {
    final String _sql = "SELECT * FROM pending_actions ORDER BY createdAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PendingActionEntity>>() {
      @Override
      @NonNull
      public List<PendingActionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "eventId");
          final int _cursorIndexOfActionType = CursorUtil.getColumnIndexOrThrow(_cursor, "actionType");
          final int _cursorIndexOfGroupCode = CursorUtil.getColumnIndexOrThrow(_cursor, "groupCode");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<PendingActionEntity> _result = new ArrayList<PendingActionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PendingActionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            final String _tmpActionType;
            if (_cursor.isNull(_cursorIndexOfActionType)) {
              _tmpActionType = null;
            } else {
              _tmpActionType = _cursor.getString(_cursorIndexOfActionType);
            }
            final String _tmpGroupCode;
            if (_cursor.isNull(_cursorIndexOfGroupCode)) {
              _tmpGroupCode = null;
            } else {
              _tmpGroupCode = _cursor.getString(_cursorIndexOfGroupCode);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new PendingActionEntity(_tmpId,_tmpEventId,_tmpActionType,_tmpGroupCode,_tmpCreatedAt);
            _result.add(_item);
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
