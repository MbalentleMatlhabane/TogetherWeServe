package com.togetherweserve.app.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile EventDao _eventDao;

  private volatile RegistrationDao _registrationDao;

  private volatile PendingActionDao _pendingActionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `events` (`eventId` TEXT NOT NULL, `title` TEXT NOT NULL, `cause` TEXT NOT NULL, `description` TEXT NOT NULL, `dateTime` INTEGER NOT NULL, `location` TEXT NOT NULL, `slotsAvailable` INTEGER NOT NULL, `volunteersGoing` INTEGER NOT NULL, `organiserId` TEXT NOT NULL, `organiserName` TEXT NOT NULL, PRIMARY KEY(`eventId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `registrations` (`registrationId` TEXT NOT NULL, `eventId` TEXT NOT NULL, `eventTitle` TEXT NOT NULL, `eventDateTime` INTEGER NOT NULL, `groupId` TEXT, `status` TEXT NOT NULL, PRIMARY KEY(`registrationId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `pending_actions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `eventId` TEXT NOT NULL, `actionType` TEXT NOT NULL, `groupCode` TEXT, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '18c9efc90d5a48bb4365513a34850672')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `events`");
        db.execSQL("DROP TABLE IF EXISTS `registrations`");
        db.execSQL("DROP TABLE IF EXISTS `pending_actions`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsEvents = new HashMap<String, TableInfo.Column>(10);
        _columnsEvents.put("eventId", new TableInfo.Column("eventId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("cause", new TableInfo.Column("cause", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("dateTime", new TableInfo.Column("dateTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("slotsAvailable", new TableInfo.Column("slotsAvailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("volunteersGoing", new TableInfo.Column("volunteersGoing", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("organiserId", new TableInfo.Column("organiserId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("organiserName", new TableInfo.Column("organiserName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEvents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEvents = new TableInfo("events", _columnsEvents, _foreignKeysEvents, _indicesEvents);
        final TableInfo _existingEvents = TableInfo.read(db, "events");
        if (!_infoEvents.equals(_existingEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "events(com.togetherweserve.app.data.local.EventEntity).\n"
                  + " Expected:\n" + _infoEvents + "\n"
                  + " Found:\n" + _existingEvents);
        }
        final HashMap<String, TableInfo.Column> _columnsRegistrations = new HashMap<String, TableInfo.Column>(6);
        _columnsRegistrations.put("registrationId", new TableInfo.Column("registrationId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegistrations.put("eventId", new TableInfo.Column("eventId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegistrations.put("eventTitle", new TableInfo.Column("eventTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegistrations.put("eventDateTime", new TableInfo.Column("eventDateTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegistrations.put("groupId", new TableInfo.Column("groupId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegistrations.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRegistrations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRegistrations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRegistrations = new TableInfo("registrations", _columnsRegistrations, _foreignKeysRegistrations, _indicesRegistrations);
        final TableInfo _existingRegistrations = TableInfo.read(db, "registrations");
        if (!_infoRegistrations.equals(_existingRegistrations)) {
          return new RoomOpenHelper.ValidationResult(false, "registrations(com.togetherweserve.app.data.local.RegistrationEntity).\n"
                  + " Expected:\n" + _infoRegistrations + "\n"
                  + " Found:\n" + _existingRegistrations);
        }
        final HashMap<String, TableInfo.Column> _columnsPendingActions = new HashMap<String, TableInfo.Column>(5);
        _columnsPendingActions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPendingActions.put("eventId", new TableInfo.Column("eventId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPendingActions.put("actionType", new TableInfo.Column("actionType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPendingActions.put("groupCode", new TableInfo.Column("groupCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPendingActions.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPendingActions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPendingActions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPendingActions = new TableInfo("pending_actions", _columnsPendingActions, _foreignKeysPendingActions, _indicesPendingActions);
        final TableInfo _existingPendingActions = TableInfo.read(db, "pending_actions");
        if (!_infoPendingActions.equals(_existingPendingActions)) {
          return new RoomOpenHelper.ValidationResult(false, "pending_actions(com.togetherweserve.app.data.local.PendingActionEntity).\n"
                  + " Expected:\n" + _infoPendingActions + "\n"
                  + " Found:\n" + _existingPendingActions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "18c9efc90d5a48bb4365513a34850672", "9ac385e804d836d70e41dd4dd84535bb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "events","registrations","pending_actions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `events`");
      _db.execSQL("DELETE FROM `registrations`");
      _db.execSQL("DELETE FROM `pending_actions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RegistrationDao.class, RegistrationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PendingActionDao.class, PendingActionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public EventDao eventDao() {
    if (_eventDao != null) {
      return _eventDao;
    } else {
      synchronized(this) {
        if(_eventDao == null) {
          _eventDao = new EventDao_Impl(this);
        }
        return _eventDao;
      }
    }
  }

  @Override
  public RegistrationDao registrationDao() {
    if (_registrationDao != null) {
      return _registrationDao;
    } else {
      synchronized(this) {
        if(_registrationDao == null) {
          _registrationDao = new RegistrationDao_Impl(this);
        }
        return _registrationDao;
      }
    }
  }

  @Override
  public PendingActionDao pendingActionDao() {
    if (_pendingActionDao != null) {
      return _pendingActionDao;
    } else {
      synchronized(this) {
        if(_pendingActionDao == null) {
          _pendingActionDao = new PendingActionDao_Impl(this);
        }
        return _pendingActionDao;
      }
    }
  }
}
