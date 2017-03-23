// Generated code from Butter Knife. Do not modify!
package com.example.emad.splashscreen;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$ViewBinder<T extends MainActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558521, "field '_emailText'");
    target._emailText = finder.castView(view, 2131558521, "field '_emailText'");
    view = finder.findRequiredView(source, 2131558522, "field '_passwordText'");
    target._passwordText = finder.castView(view, 2131558522, "field '_passwordText'");
    view = finder.findRequiredView(source, 2131558523, "field '_loginButton'");
    target._loginButton = finder.castView(view, 2131558523, "field '_loginButton'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MainActivity> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target._emailText = null;
      target._passwordText = null;
      target._loginButton = null;
    }
  }
}
