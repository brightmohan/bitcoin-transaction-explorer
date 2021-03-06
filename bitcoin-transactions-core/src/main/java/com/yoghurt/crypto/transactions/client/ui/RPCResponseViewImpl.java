package com.yoghurt.crypto.transactions.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yoghurt.crypto.transactions.client.di.BitcoinPlaceRouter;
import com.yoghurt.crypto.transactions.client.widget.BitcoinJSONViewer;

@Singleton
public class RPCResponseViewImpl extends Composite implements RPCResponseView {
  interface ScriptViewImplUiBinder extends UiBinder<Widget, RPCResponseViewImpl> {
  }

  private static final ScriptViewImplUiBinder UI_BINDER = GWT.create(ScriptViewImplUiBinder.class);

  @UiField(provided = true) BitcoinJSONViewer jsonViewer;

  @Inject
  public RPCResponseViewImpl(final BitcoinPlaceRouter router) {
    jsonViewer = new BitcoinJSONViewer(router);

    initWidget(UI_BINDER.createAndBindUi(this));
  }

  @Override
  public void setResponse(final String jsonString) {
    jsonViewer.setValue(jsonString);
  }
}
