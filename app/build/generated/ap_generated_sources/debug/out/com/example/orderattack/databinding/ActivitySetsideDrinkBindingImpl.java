package com.example.orderattack.databinding;
import com.example.orderattack.R;
import com.example.orderattack.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySetsideDrinkBindingImpl extends ActivitySetsideDrinkBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.setsidedrink_back, 1);
        sViewsWithIds.put(R.id.colamedium, 2);
        sViewsWithIds.put(R.id.spritemedium, 3);
        sViewsWithIds.put(R.id.fantamedium, 4);
        sViewsWithIds.put(R.id.colazero, 5);
        sViewsWithIds.put(R.id.zadu, 6);
        sViewsWithIds.put(R.id.jeju, 7);
        sViewsWithIds.put(R.id.vanilashake, 8);
        sViewsWithIds.put(R.id.icedripcoffee, 9);
        sViewsWithIds.put(R.id.iceamericano, 10);
        sViewsWithIds.put(R.id.icecafelatte, 11);
        sViewsWithIds.put(R.id.icevanillalatte, 12);
        sViewsWithIds.put(R.id.hotdripcoffee, 13);
        sViewsWithIds.put(R.id.kpop_8, 14);
        sViewsWithIds.put(R.id.kipoint, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySetsideDrinkBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivitySetsideDrinkBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageButton) bindings[2]
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.ImageButton) bindings[4]
            , (android.widget.ImageButton) bindings[13]
            , (android.widget.ImageButton) bindings[10]
            , (android.widget.ImageButton) bindings[11]
            , (android.widget.ImageButton) bindings[9]
            , (android.widget.ImageButton) bindings[12]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageButton) bindings[3]
            , (android.widget.ImageButton) bindings[8]
            , (android.widget.ImageButton) bindings[6]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}