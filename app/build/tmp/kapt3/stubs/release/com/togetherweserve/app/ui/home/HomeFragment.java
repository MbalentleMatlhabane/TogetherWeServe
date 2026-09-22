package com.togetherweserve.app.ui.home;

/**
 * FR5 - Event discovery: searchable, filterable feed of nearby events
 * grouped by cause, matching the "Home / Event Feed" wireframe.
 * Reads through EventRepository so the feed still shows the last-cached
 * events when the device is offline (FR8).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/togetherweserve/app/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/togetherweserve/app/databinding/FragmentHomeBinding;", "adapter", "Lcom/togetherweserve/app/ui/home/EventAdapter;", "binding", "getBinding", "()Lcom/togetherweserve/app/databinding/FragmentHomeBinding;", "causes", "", "", "latestEvents", "Lcom/togetherweserve/app/data/local/EventEntity;", "repository", "Lcom/togetherweserve/app/data/repository/EventRepository;", "filterEvents", "events", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "openEventDetail", "event", "refresh", "app_release"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.togetherweserve.app.databinding.FragmentHomeBinding _binding;
    private com.togetherweserve.app.data.repository.EventRepository repository;
    private com.togetherweserve.app.ui.home.EventAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> causes = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.togetherweserve.app.data.local.EventEntity> latestEvents;
    
    public HomeFragment() {
        super();
    }
    
    private final com.togetherweserve.app.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void refresh() {
    }
    
    private final java.util.List<com.togetherweserve.app.data.local.EventEntity> filterEvents(java.util.List<com.togetherweserve.app.data.local.EventEntity> events) {
        return null;
    }
    
    private final void openEventDetail(com.togetherweserve.app.data.local.EventEntity event) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}